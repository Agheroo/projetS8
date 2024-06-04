var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('users-temp',{app_name : "[Logs-it]",
  pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
          {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
          {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard"}],
  puzzles :[{topic: "Linux", diff : 0, time : 120, score : 1560, assisted : 0},
            {topic: "Prog objet", diff : 1, time : 452, score : 260, assisted : 2},
            {topic: "Analyse", diff: 2, time : 313, score : 612, assisted : 1},
            {topic: "Application Web",diff : 1, time : 410, score : 104, assisted : 1}
  ]              
  });
});

module.exports = router;
