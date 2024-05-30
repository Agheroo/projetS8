var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('puzzles', 
  
  {app_name : "[Logs-it]",
    });
});

module.exports = router;
