module.exports = function(grunt) {
    // Project configuration
    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        assetsDirectory: "src/main/webapp/WEB-INF/assets",
        // grunt-contrib-less
        less: {
            common: {
                files: {
                    "<%= assetsDirectory %>/css/common.css": "<%= assetsDirectory %>/css/common.less"
                }
            }
        },
        // grunt-contrib-cssmin
        cssmin: {
            common: {
                files: [{
                    expand: true,
                    cwd: "<%= assetsDirectory %>/css/",
                    src: "common.css",
                    dest: "<%= assetsDirectory %>/css/",
                    ext: ".min.css"
                }]
            }
        }
    });

    // Load NPM tasks
    grunt.loadNpmTasks("grunt-contrib-less");
    grunt.loadNpmTasks("grunt-contrib-cssmin");

    // Register custom tasks
    grunt.registerTask(
        "default",
        ["less", "cssmin"]
    );
};