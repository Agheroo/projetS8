var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('puzzle-temp',{app_name : "[Logs-it]",
  pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
          {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
          {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard"}],
  users : [{name: "Joueur1", time : 253, score : 553, assisted : "Word"},
            {name: "Joueur2", time : 123, score : 667, assisted : "None"},
            {name: "Joueur3", time : 645, score : 345, assisted : "Letter"},
            {name: "Joueur665", time : 410, score : 788, assisted : "Letter"},
            {name: "Joueur28", time : 110, score : 989, assisted : "None"}
  ]              
  });
});

module.exports = router;
