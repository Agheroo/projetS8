var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {app_name: "Word-it"});
});

module.exports = router;
