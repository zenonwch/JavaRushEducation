package com.javarush.test.level25.lesson16.big01;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс игры - Космос (Space)
 */
public class Space {
	//Ширина и высота игрового поля
	private int width;
	private int height;

	//Космический корабль
	private SpaceShip ship;
	//Список НЛО
	private ArrayList<Ufo> ufos = new ArrayList<Ufo>();
	//Список бомб
	private ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	//Список ракет
	private ArrayList<Rocket> rockets = new ArrayList<Rocket>();

	public Space(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Основной цикл программы.
	 * Тут происходят все важные действия
	 */
	public void run() {
		//Создаем холст для отрисовки.
		Canvas canvas = new Canvas(width, height);

		//Создаем объект "наблюдатель за клавиатурой" и стартуем его.
		KeyboardObserver keyboardObserver = new KeyboardObserver();
		keyboardObserver.start();

		//Игра работает, пока корабль жив
		while (ship.isAlive()) {
			//"наблюдатель" содержит события о нажатии клавиш?
			if (keyboardObserver.hasKeyEvents()) {
				KeyEvent event = keyboardObserver.getEventFromTop();
				//Если "стрелка влево" - сдвинуть фигурку влево
				System.out.print(event.getKeyCode());
				if (event.getKeyCode() == KeyEvent.VK_LEFT)
					ship.moveLeft();
					//Если "стрелка вправо" - сдвинуть фигурку вправо
				else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
					ship.moveRight();
					//Если "пробел" - запускаем шарик
				else if (event.getKeyCode() == KeyEvent.VK_SPACE)
					ship.fire();
			}

			//двигаем все объекты игры
			moveAllItems();

			//проверяем столкновения
			checkBombs();
			checkRockets();
			//удаляем умершие объекты из списков
			removeDead();

			//Создаем НЛО (1 раз в 10 ходов)
			createUfo();

			//Отрисовываем все объекты на холст, а холст выводим на экран
			canvas.clear();
			draw(canvas);
			canvas.print();

			//Пауза 300 миллисекунд
			Space.sleep(300);
		}

		//Выводим сообщение "Game Over"
		System.out.println("Game Over!");
	}

	/**
	 * Двигаем все объекты игры
	 */
	public void moveAllItems() {
		for (BaseObject obj : getAllItems()) obj.move();
	}

	/**
	 * Метод возвращает общий список, который содержит все объекты игры
	 */
	public List<BaseObject> getAllItems() {
		List<BaseObject> allItems = new ArrayList<>();
		allItems.add(ship);
		allItems.addAll(ufos);
		allItems.addAll(rockets);
		allItems.addAll(bombs);
		return allItems;
	}

	/**
	 * Создаем новый НЛО. 1 раз на 10 вызовов.
	 */
	public void createUfo() {
		if (ufos.isEmpty()) ufos.add(new Ufo(width / 2, 0));
	}

	/**
	 * Проверяем бомбы.
	 * а) столкновение с кораблем (бомба и корабль умирают)
	 * б) падение ниже края игрового поля (бомба умирает)
	 */
	public void checkBombs() {
		for (Bomb bomb : bombs) {
			if (bomb.y > height) bomb.die();
			if (bomb.isIntersec(ship)) {
				bomb.die();
				ship.die();
			}
		}
	}

	/**
	 * Проверяем рокеты.
	 * а) столкновение с НЛО (ракета и НЛО умирают)
	 * б) вылет выше края игрового поля (ракета умирает)
	 */
	public void checkRockets() {
		for (Rocket rocket : rockets) {
			if (rocket.y < 0) rocket.die();
			for (Ufo ufo : ufos) {
				if (rocket.isIntersec(ufo)) {
					rocket.die();
					ufo.die();
				}
			}
		}
	}

	/**
	 * Удаляем умерсшие объекты (бомбы, ракеты, НЛО) из списков
	 */
	public void removeDead() {
		List<Bomb> copyBombs = new ArrayList<>(getBombs());
		List<Rocket> copyRockets = new ArrayList<>(getRockets());
		List<Ufo> copyUfos = new ArrayList<>(getUfos());
		for (Bomb bomb : copyBombs) if (!bomb.isAlive()) getBombs().remove(bomb);
		for (Rocket rocket : copyRockets) if (!rocket.isAlive()) getRockets().remove(rocket);
		for (Ufo ufo : copyUfos) if (!ufo.isAlive()) getUfos().remove(ufo);
	}

	/**
	 * Отрисовка всех объектов игры:
	 * а) заполняем весь холст точесками.
	 * б) отрисовываем все объекты на холст.
	 */
	public void draw(Canvas canvas) {
		//тут нужно отрисовать все объекты игры
	}


	public SpaceShip getShip() {
		return ship;
	}

	public void setShip(SpaceShip ship) {
		this.ship = ship;
	}

	public ArrayList<Ufo> getUfos() {
		return ufos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Bomb> getBombs() {
		return bombs;
	}

	public ArrayList<Rocket> getRockets() {
		return rockets;
	}

	public static Space game;

	public static void main(String[] args) throws Exception {
		game = new Space(20, 20);
		game.setShip(new SpaceShip(10, 16));
		game.run();
	}

	/**
	 * Метод делает паузу длинной delay миллисекунд.
	 */
	public static void sleep(int delay) {
		try {
			Thread.sleep(delay);
		}
		catch (InterruptedException e) {
		}
	}
}
