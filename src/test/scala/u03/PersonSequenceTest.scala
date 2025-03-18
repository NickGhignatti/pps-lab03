package u03

import org.junit.Assert.assertEquals
import org.junit.Test
import u02.Modules.Person.{Student, Teacher}
import u03.Sequences.Sequence
import u03.Sequences.Sequence.{Cons, Nil, sum}
import u02.Modules.*

class PersonSequenceTest:
  val sequence: Sequence[Person] = Cons(Student("Nicolò", 2002), Cons(Teacher("Viroli", "PPS"), Nil()))

  @Test def testCoursesFromTeachers(): Unit =
    assertEquals(Cons("PPS", Nil()), sequence.getTeachersCourses())

  @Test def testFoldLeft(): Unit =
    val list: Sequence[Int] = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
    assertEquals(-16, list.foldLeft(0)(_ - _))

  @Test def testNumberOfCourses(): Unit =
    assertEquals(1, sequence.getAllCoursesNumber())
