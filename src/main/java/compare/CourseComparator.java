package compare;

import data.Student;

public class CourseComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getCourse().getValue() - o2.getCourse().getValue();
	}

}
