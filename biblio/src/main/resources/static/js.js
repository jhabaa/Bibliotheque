var users = document.querySelectorAll("#card");

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

  users.forEach(function(user) {
    user.addEventListener("mouseover", function() {
        user.classList.remove("hide");
        user.style.transform = "scale(1.2)";
        user.style.transition = "transform 0.5s";
    });
    user.addEventListener("mouseout", function() {
        user.classList.add("hide");
      user.style.transform = "scale(1)";
      user.style.transition = "transform 0.5s";
    });
  })