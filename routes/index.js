var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', 
  {app_name: "[Logs-it]",
   pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
            {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
            {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez quels sont leurs scores !", link: "/leaderboard"}]

  });
});

module.exports = router;
