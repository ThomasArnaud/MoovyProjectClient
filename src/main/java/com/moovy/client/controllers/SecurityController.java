package com.moovy.client.controllers;

import com.moovy.client.entities.User;
import com.moovy.client.services.UsersService;
import com.moovy.client.utils.EmailUtils;
import com.moovy.client.validators.UserValidator;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.Calendar;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class SecurityController extends AbstractController
{
    /**
     * {@inheritDoc}
     */
    public SecurityController(HttpServletRequest request)
    {
        super(request);
    }

    /**
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new UserValidator());
    }

    /**
     * Displays the login form.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
         return this.render("security/login");
    }

    /**
     * Handles the login process.
     *
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(
        @RequestParam(value = "email", required = false) String email,
        @RequestParam(value = "password", required = false) String password
    )
    {
        // Initialize vars
        String emailError = null, passwordError = null;

        if(email != null && !email.isEmpty())
        {
            if(!EmailUtils.isValid(email))
            {
                emailError = "Votre adresse e-mail est invalide.";
            }
        }
        else
        {
            emailError = "Vous devez préciser votre adresse e-mail.";
        }

        if(password == null || password.isEmpty())
        {
            passwordError = "Vous devez préciser votre mot de passe.";
        }

        if(emailError == null && passwordError == null)
        {
            // Try logging in
            UsersService usersService = new UsersService();
            User user = usersService.login(email, password);

            // Has the user successfully logged in?
            if(user != null)
            {
                // Register user id
                this.request.getSession().setAttribute("_user", user);
                this.addFlash(
                    "success",
                    String.format(
                        "Vous êtes maintenant connecté(e) en tant que <strong>%s %s</strong>.",
                        StringEscapeUtils.escapeHtml(user.getFirstName()),
                        StringEscapeUtils.escapeHtml(user.getLastName())
                    )
                );

                return this.redirect("/");
            }
            else
            {
                // Build model
                ModelMap model = new ModelMap();

                model.addAttribute("lastEmail", email);
                model.addAttribute("loginError", "L'adresse email ou le mot de passe est incorrect.");

                return this.render("security/login", model);
            }
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("lastEmail", email);
            model.addAttribute("emailError", emailError);
            model.addAttribute("passwordError", passwordError);

            return this.render("security/login", model);
        }
    }

    /**
     * Handles the logging out process.
     *
     * @return A redirection.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView doLogout()
    {
        // Remove user id from session
        this.request.getSession().removeAttribute("_user");

        return this.redirect("/login");
    }

    /**
     * Displays the registration form.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register()
    {
        // Build model
        ModelMap model = new ModelMap();

        model.addAttribute("user", new User());

        return this.render("security/register", model);
    }

    /**
     * Handles the registration process.
     *
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView doRegister(
        @ModelAttribute("user") @Validated User user,
        BindingResult result,
        @RequestParam(value = "password_confirmation", required = false) String passwordConfirmation,
        @RequestParam(value = "terms", required = false) boolean termsAccepted
    )
    {
        // Initialize vars
        String passwordConfirmationError = null;
        String termsAcceptedError = null;

        if(passwordConfirmation != null && !passwordConfirmation.trim().isEmpty())
        {
            if(!passwordConfirmation.equals(user.getPassword()))
            {
                passwordConfirmationError = "Votre mot de passe est différent de sa confirmation.";
                result.reject(null, passwordConfirmationError);
            }
        }
        else
        {
            passwordConfirmationError = "Vous devez remplir la confirmation du mot de passe.";
            result.reject(null, passwordConfirmationError);
        }

        if(!termsAccepted)
        {
            termsAcceptedError = "Vous devez accepter les conditions d'utilisation du site.";
            result.reject(null, termsAcceptedError);
        }

        if(!result.hasErrors())
        {
            // Set creation date
            user.setCreatedAt(new Date(Calendar.getInstance().getTimeInMillis()));

            // Register user
            UsersService usersService = new UsersService();
            Response response = usersService.register(user);

            if(response.getStatus() == Response.Status.OK.getStatusCode())
            {
                // User has been successfully created
                this.addFlash("success", "Vous pouvez dès maintenant vous connecter.");

                return this.redirect("/login");
            }
            else if(response.getStatus() == Response.Status.CONFLICT.getStatusCode())
            {
                result.rejectValue("email", null, "Cette adresse e-mail est déjà utilisée.");

                // Build model
                ModelMap model = new ModelMap();

                model.addAttribute("user", user);

                return this.render("security/register", model);
            }
            else
            {
                throw new RuntimeException("Une erreur inattendue est survenue lors de votre inscription.");
            }
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("user", user);
            model.addAttribute("passwordConfirmationError", passwordConfirmationError);
            model.addAttribute("termsAcceptedError", termsAcceptedError);

            return this.render("security/register", model);
        }
    }
}
