var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/:id', function (req, res, next) {
  fetch("http://backend:8080/grids/" + req.params.id + "/gridPlayers", {
    "headers": {
      "content-type": "application/json"
    },
    "body": null,
    "method": "GET"
  }).then(data => {
    data.json().then(users => {
      res.render('puzzle-temp', {
        app_name: "[Logs-it]",
        pages: [{ name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles" },
        { name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users" },
        { name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard" }],
        users: users
      });
    });
  });
});

module.exports = router;
