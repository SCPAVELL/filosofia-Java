package dataTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Mercury {
	public static void main(String args) {
		// время начала работы над задачей — 9:00
		LocalTime taskStart = LocalTime.of(9, 0);
		// время окончания работы над задачей — 11:30
		LocalTime taskFinish = LocalTime.of(11, 30);

		// Опишите формат вывода в виде часы:минуты
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		// Найдите продолжительность между двумя единицами времени
		Duration duration = Duration.between(taskStart, taskFinish);

		// taskStart должен быть выведен в указанном формате
		System.out.println("В прошлый раз задача была начата в " + formatter.format(taskStart) + ",");
		// taskFinish должен быть выведен в указанном формате
		System.out.println("а закончена в " + formatter.format(taskFinish) + ".");

		LocalTime now = LocalTime.now();
		// now должен быть выведен в указанном формате
		System.out.println("Сейчас " + formatter.format(now) + ".");

		// Прибавьте к текущему моменту вычисленную продолжительность
		LocalTime finishTime = now.plus(duration);

		// finishTime должен быть выведен в указанном формате
		System.out.println("Значит, задача будет выполнена к " + formatter.format(finishTime) + ".");
	}
}