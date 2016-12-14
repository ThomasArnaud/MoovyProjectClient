module.exports = function(grunt) {
    // Project configuration
    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        assetsDirectory: "src/main/webapp/WEB-INF/assets",
        // grunt-contrib-less
        less: {
            common: {
                files: {
                    "<%= assetsDirectory %>/common.css": "<%= assetsDirectory %>/less/common.less"
                }
            }
        },
        // grunt-contrib-cssmin
        cssmin: {
            common: {
                files: [{
                    expand: true,
                    cwd: "<%= assetsDirectory %>/",
                    src: "common.css",
                    dest: "<%= assetsDirectory %>/public/css/",
                    ext: ".min.css"
                }]
            }
        },
        clean: [
            "<%= assetsDirectory %>/common.css"
        ]
    });

    // Load NPM tasks
    grunt.loadNpmTasks("grunt-contrib-less");
    grunt.loadNpmTasks("grunt-contrib-cssmin");
    grunt.loadNpmTasks('grunt-contrib-clean');

    // Register custom tasks
    grunt.registerTask(
        "default",
        ["less", "cssmin", "clean"]
    );
};