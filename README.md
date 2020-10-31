#There are three methods in this project.

1. Find Index Method
[Method Type] : POST
[URL] : http://localhost:9292/api/findWordIndex
[Request Body] :
{
    "word" : "barfoothefoobarman",
    "wordList" : ["foo","bar"]
}
[Response Body] :
{
    "validationResult": {
        "errorType": "None",
        "errors": [],
        "valid": true
    },
    "indexes": [
        0,
        9
    ]
}



#To demostrate hibernate configurations and working, I've created below two methods.
[PRE REQUISITE FOR BELOW METHODS] 
1. Running instance MySql 
2. Update database name, username and password in "hibernate.cfg.xml" under resources folder.

[METHODS] 
1. Save Word Method : saves a word in DB.
[Method Type] : POST
[URL] : http://localhost:9292/api/saveWord
[Request Body] : (any valid string)
[Response Body] :
{
    "validationResult": {
        "errorType": "None",
        "errors": [],
        "valid": true
    },
    "result": true
}


2. Gets Words Method : returns list of all words in DB.
[Method Type] : GET
[URL] : http://localhost:9292/api/getWords
[Response Body] :
{
    "validationResult": {
        "errorType": "None",
        "errors": [],
        "valid": true
    },
    "result": [
        {
            "id": 1,
            "word": "hello2"
        },
        {
            "id": 2,
            "word": "hello2"
        }
    ]
}