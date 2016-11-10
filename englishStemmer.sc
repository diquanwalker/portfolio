import $ivy.`com.github.rholder:snowball-stemmer:1.3.0.581.1`

import org.tartarus.snowball.SnowballStemmer

import org.tartarus.snowball.ext.englishStemmer

import scala.io.Source


def stem (stemmer: org.tartarus.snowball.ext.englishStemmer,
          s: String) = {
  stemmer.setCurrent(s)
  stemmer.stem()
  stemmer.getCurrent.toLowerCase
}



@main
def stemWord(fileName: String) {
  val txt = Source.fromFile(fileName).getLines.mkString(" ")
  val stemmer = new englishStemmer()

  val wds = txt.split("\\W")
  for (wd <-wds) {
    println( stem(stemmer, wd))
  }


}
