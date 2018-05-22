const Song = require("./Song.js");

class Lesson21 extends Song.Song {
  constructor() {
    super();
  }

  singSong(style, names) {
    switch (style) {
      case 1 :
        this.singVerse(names, true, "L", 0, "Hip Hip Horray! For ");
        break;

      case 2 :
        this.singVerse(names, true, "am", 1, "Say yeah! Say yo! Say ");
        break;

      case 3 :
        this.singVerse(names, false);
        break;
    }
  }

  singVerse(names, shouldSingLyric, searchString, position, lyrics) {
    for (var i = 0; i < names.length; i++) {
      var name = names[i];
      if (shouldSingLyric && name.startsWith(searchString, position)) {
        this.sing(lyrics + name);
      }
      else {
        this.sing("Hello " + name + ", it's nice to meet you.");
      }
    }
  }
}


module.exports = {
  Lesson21
}
