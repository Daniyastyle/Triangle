// Печать треугольника
// Напишите программу, которая выводит треугольник из звездочек (*) с высотой, заданной пользователем.
// Используйте вложенные циклы for для создания треугольника.

import java.util.Scanner; // Подключаем класс сканер

public class PrintTriangle {
	public static void main(String[] args) {
		System.out.println("Print Triangle"); // Просто принт

		Scanner sc = new Scanner(System.in); // Создаем инстанс с указанием аргумента System.in(ввод в консоль)

		int height = sc.nextInt(); // Читаем int(целочисленное) высоту треугольника

		for (int i = 0; i < height; i++) { // от нуля до введенного числа
			for (int j = 0; j < (i+1); j++) { // он нуля до текущего прогона
				System.out.print("*");
			}
			System.out.print("\n"); // Новая строка
		}

		sc.close(); // Очищаем память
	}
}
