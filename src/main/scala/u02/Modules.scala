package u02

object Modules extends App:

  // An ADT: type + module
  enum Person:
    case Student(name: String, year: Int)
    case Teacher(name: String, course: String)

  object Person:
    def name(p: Person): String = p match
      case Student(n, _) => n
      case Teacher(n, _) => n

  import Person.*

  // a method outside the Person module
  def isStudent(p: Person): Boolean = p match
    case Student(_, _) => true
    case _ => false

  import u03.Sequences.*

  extension (s: Sequence[Person])
    def getTeachersCourses(): Sequence[String] = s.filter((p: Person) => !isStudent(p)).map((t: Person) => t.asInstanceOf[Teacher].course)

    def getAllCoursesNumber(): Int = s.filter((p: Person) => !isStudent(p)).map(t => 1).foldLeft(0)(_ + _)

end Modules
