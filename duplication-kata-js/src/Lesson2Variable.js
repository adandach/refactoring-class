const Song = require("./Song.js");

class Lesson2Variable extends Song.Song {
  constructor() {
    super();
  }

  singBottlesOfBeer() {
    this.singVerse(100);
    this.singVerse(99);
  }

  singVerse(bottlesOfBeer) {
    this.sing(bottlesOfBeer + " bottles of beer on the wall");
    this.sing(bottlesOfBeer + " bottles of beer");
    this.sing("Take one down, pass it around");
    this.sing((bottlesOfBeer - 1) + " bottles of beer on the wall");
  }
}


module.exports = {
  Lesson2Variable
}
