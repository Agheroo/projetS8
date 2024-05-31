var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('users',
  {app_name : "[Logs-it]",
  pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
          {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
          {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard"}],    
  users : [{name : "Player664", avgScore : 642, rank : 2},
          {name : "Player7", avgScore : 134, rank : 6},
          {name : "Player1", avgScore : 345, rank : 3},
          {name : "Player956", avgScore : 846, rank : 1},
          {name : "Player12", avgScore : 210, rank : 5},
          {name : "Player9", avgScore : 320, rank : 4},
  ]
  });
});

module.exports = router;
