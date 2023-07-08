# Testing ClickUp's REST API With Rest Assured

## Overview
Educational project for learning REST API Test Automation with Rest Assured. Target API provided by ClickUp
https://clickup.com/

## Prerequisites
You will need to create an account on ClickUp and generate your personal API Token. Consult: 
https://clickup.com/api/developer-portal/authentication/

Additionally for few requests you will need {{teamID}} - you can get it from the url after you log in with your account:  
`https://app.clickup.com/{{teamId}}/home`

After cloning this repository provide both values in: 
../src/main/resources/clickup.properties
```
clickup.token=YOUR_API_TOKEN
clickup.teamid=YOUR_TEAM_ID
```

## Jenkins
You can run the tests on Jenkins - use this command as Maven Goal in Jenkins Build Step (fill in your token and teamId):
> clean test -DTOKEN=`YOUR_API_TOKEN` -DTEAM_ID=`YOUR_TEAM_ID`

## Useful Links
### ClickUp REST API documentation for used requests
https://clickup.com/api/clickupreference/operation/CreateSpace/
https://clickup.com/api/clickupreference/operation/DeleteSpace/

https://clickup.com/api/clickupreference/operation/CreateFolderlessList/

https://clickup.com/api/clickupreference/operation/CreateTask/
https://clickup.com/api/clickupreference/operation/UpdateTask/

### ClickUp API Postman Collection

https://clickup.com/api/developer-portal/postman/