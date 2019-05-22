How to push and set up heroku:

    - Create repo with github
    - Sign up with Heroku and create new app
        - Set up pipline and connect Github with app
    - In project, create "Profile" with no extension and add "web java $JAVA_OPTS -Dserver.port=$PORT -jar build/libs/*.war" [This will start up when pushed]

    - Enable when master is push, auto deploy



EXAMPLE GET ENDPOINTS:

- /trade/transaction/team/Kansas
- /trade/transaction/user/2
- /api
- /owns/2

- http://localhost:8080/market
- http://localhost:8080/market?allTeams=true

<select id="testId">
        <option th:each="item: ${itemsMap}"
                th:value="${item['key']}"
                th:text="${item['value']}" />
</select>