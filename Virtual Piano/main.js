let a = "aaaaa/A.mp3";
let s = "aaaaa/S.mp3";
let d = "aaaaa/D.mp3";
let f = "aaaaa/F.mp3";
let g = "aaaaa/G.mp3";
let h = "aaaaa/H.mp3";
let j = "aaaaa/J.mp3";
let w = "aaaaa/W.mp3";
let e1 = "aaaaa/E.mp3";
let t = "aaaaa/T.mp3";
let y = "aaaaa/Y.mp3";
let u = "aaaaa/U.mp3";
document.addEventListener("keydown", function (e) {
    let audio;
    switch (e.key) {
        case "A":
        case "a":
            audio = new Audio(a);
            audio.play();
            console.log("The 'A' key is pressed");
            break;
        case "S":
        case "s":
            audio = new Audio(s);
            audio.play();
            console.log("The 'S' key is pressed");
            break;
        case "D":
        case "d":
            audio = new Audio(d);
            audio.play();
            console.log("The 'D' key is pressed");
            break;
        case "F":
        case "f":
            audio = new Audio(f);
            audio.play();
            console.log("The 'F' key is pressed");
            break;
        case "G":
        case "g":
            audio = new Audio(g);
            audio.play();
            console.log("The 'G' key is pressed");
            break;
        case "H":
        case "h":
            audio = new Audio(h);
            audio.play();
            console.log("The 'H' key is pressed");
            break;
        case "J":
        case "j":
            audio = new Audio(j);
            audio.play();
            console.log("The 'J' key is pressed");
            break;
        case "W":
        case "w":
            audio = new Audio(w);
            audio.play();
            console.log("The 'W' key is pressed");
            break;
        case "E":
        case "e":
            audio = new Audio(e1);
            audio.play();
            console.log("The 'E' key is pressed");
            break;
        case "T":
        case "t":
            audio = new Audio(t);
            audio.play();
            console.log("The 'T' key is pressed");
            break;
        case "Y":
        case "y":
            audio = new Audio(y);
            audio.play();
            console.log("The 'Y' key is pressed");
            break;
        case "U":
        case "u":
            audio = new Audio(u);
            audio.play();
            console.log("The 'U' key is pressed");
            break;
        default:
            console.log("Make sure you connect the external scripts to the HTML. Otherwise, the new functionality of the musical instrument will not be available.")
            break;
    }
})
