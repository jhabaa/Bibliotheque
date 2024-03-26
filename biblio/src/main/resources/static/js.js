var users = document.querySelectorAll("#card");
/*
VANTA.BIRDS({
    el: "#body",
    mouseControls: true,
    touchControls: true,
    gyroControls: false,
    minHeight: 200.00,
    minWidth: 200.00,
    scale: 1.00,
    scaleMobile: 1.00,
    backgroundColor: 0xf0f0f0,
    color1: 0xe1e1e1,
    color2: 0x101516,
    colorMode: "lerpGradient",
    birdSize: 2.10,
    wingSpan: 35.00,
    separation: 58.00,
    cohesion: 7.00
  })
*/


// Change head opacity on scroll
window.addEventListener("scroll", function() {
    var header = document.querySelector(".head");
    header.style.opacity = 1 - +window.scrollY/500+"";
})
document.querySelector('#connexion_btn').addEventListener('click', function() {
    document.querySelector('#connexion_btn').classList.toggle('active');
    document.querySelector('.connexion_form').classList.toggle('active');
    if (document.querySelector('#connexion_btn').innerHTML == "Connexion")
        document.querySelector('#connexion_btn').innerHTML = "Fermer";
    else
      document.querySelector('#connexion_btn').innerHTML = "Connexion";
})