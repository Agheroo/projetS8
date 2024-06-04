var express = require('express');
var router = express.Router();

/* GET puzzles listing. */
router.get('/', function (req, res, next) {
  url = "http://backend:8080/grids";
  if (req.query) {
    url += "?";
    for (let key in req.query) {
      if (req.query[key])
        url += key + "=" + req.query[key];
    }
  }
  fetch(url, {
    "headers": {
      "content-type": "application/json"
    },
    "body": null,
    "method": "GET"
  }).then(data => data.json().then(puzzles => {
    res.render('puzzles',
      {
        app_name: "[Logs-it]",
        pages: [{ name: "Puzzles", desc: "Apprenez-en plus sur les performances des utilisateurs sur le puzzle de votre choix !", link: "/puzzles" },
        { name: "Users", desc: "Vous êtes curieux du travail qu'a produit un utilisateur en particulier ?", link: "/users" },
        { name: "Leaderboard", desc: "Envie de faire partie des meilleurs ? Regardez où vous en êtes dans le classement !", link: "/leaderboard" }],

        //This list should be updated with fetching database accoring to form GET
        puzzles: puzzles


      });
  })
  )

});

module.exports = router;
