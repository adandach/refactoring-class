const Song = require("./Song.js");

class Lesson1Straight extends Song.Song {
  constructor() {
    super();
  }

  singCatSong() {
    this.singVerse("We gave the cat to a little kid");
    this.singVerse("We sent the cat out on a boat");
  }

  singVerse(text) {
    this.sing(text);
    this.sing("But the cat came back");
    this.sing("The very next day");
    this.sing("Oh the cat came back");
    this.sing("We thought he was a goner");
    this.sing("But the cat came back, he just wouldn't go away");
  }
}


module.exports = {
  Lesson1Straight
};