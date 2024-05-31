var express = require('express');
var router = express.Router();

/* GET puzzles listing. */
router.get('/', function(req, res, next) {
  res.render('puzzles', 
  {app_name : "[Logs-it]",
    pages : [{name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles"},
            {name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users"},
            {name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard"}],

    //This list should be updated with fetching database accoring to form GET
    puzzles : [{topic : "Linux", avgScore : 365, difficulty : 0},
               {topic : "Linux", avgScore : 280, difficulty : 1}, 
               {topic : "Prog C", avgScore : 378, difficulty : 0},
               {topic : "Prog C", avgScore : 123, difficulty : 2},
               {topic : "Prog C", avgScore : 450, difficulty : 1},
               {topic : "Application web", avgScore : 652, difficulty : 0},
               {topic : "Application web", avgScore : 51, difficulty : 2}]             
    
  
  });
});

module.exports = router;
