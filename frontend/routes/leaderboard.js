var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('leaderboard',{app_name : "[Logs-it]",
  pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
          {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
          {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard"}],
  users : [{rank: 1, name: "Joueur3", avgScore : 210, bestScore : 123},{rank: 2, name: "Joueur1", avgScore : 300, bestScore : 200},{rank: 3, name: "Joueur2", avgScore : 450, bestScore : 320}]              
  });
});

module.exports = router;
