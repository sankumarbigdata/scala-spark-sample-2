/**
  * Created by Harleen
  * using ConfigFactory
  */

import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object wc {
  def main(args: Array[String]): Unit = {

    val conff = ConfigFactory.load()

    //setMaster("local[2]").
    val conf = new SparkConf().
      setMaster(conff.getConfig(args(1)).getString("executionMode")).
      setAppName("wc_wordCount")

    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    sc.textFile(args(0)).
      flatMap(x=> x.split(" ")).
      map(x=> (x,1)).
      reduceByKey((a,b)=> a+b).
      map(x=> x.productIterator.mkString("\t")).
      foreach(println)
  }

}
