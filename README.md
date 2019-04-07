How to push and set up heroku:

    - Create repo with github
    - Sign up with Heroku and create new app
        - Set up pipline and connect Github with app
    - In project, create "Profile" with no extension and add "web java $JAVA_OPTS -Dserver.port=$PORT -jar build/libs/*.war" [This will start up when pushed]

    - Enable when master is push, auto deploy



    @Restcontroller for data
    @controller for view