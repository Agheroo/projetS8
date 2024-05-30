var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('puzzles', 
  {app_name : "[Logs-it]",
    puzzles : [{name : "Linux", id : 0},{name : "Database", id : 1}, {name : "Programmation C", id : 2}],
    
                        

    });
});

module.exports = router;
