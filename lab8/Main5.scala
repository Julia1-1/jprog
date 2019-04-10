object Main5 {
  val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
  val x = strefy.filter(_.contains("Europe")).map(a => a.stripPrefix("Europe/")).sortBy(a => a.length)

  for(d <- x) println(d)
}
