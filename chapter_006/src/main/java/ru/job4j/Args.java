package ru.job4j;

public class Args {
	private String[] args;
	private String directory;
	private String expression;
	private String mark;
	private String output;
	private String[] example = new String[]{"-d", "\\w:[/\\\\].*",
											"-n", "[\\?*\\.\\w*]*",
											"-m|-f|-r", 
											"-o", "\\w:[/\\\\].*"
											};
	
	public Args(String[] args) {
		this.args = args;
	}

	/**
	 * Метод осуществляет валидацию введенной пользователем команды. Метод сравнивает
	 * поэлементно ввод пользователя, с шаблоном ввода example. Сравнивается поледовательность
	 * ввода ключей, и по регулярным выражениям - правильность набора параметров к ключам.
	 * @return
	 */
	private boolean validation() {
		boolean result = true;
		for (int i = 0; i < args.length; i++) {
			if (!this.args[i].matches(this.example[i])) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * Метод, при правильном вводе команды в cmd, расскладывает на составляющие
	 * в переменные класса параметры введенные пользователем.	 *
	 * @throws Exception
	 */
	private void decompose() throws Exception {	
		if (!this.validation()) {
			throw new Exception("Неверная команда.");
		}
		this.directory = this.args[1];
		this.expression = this.args[3];		
		this.mark = this.args[4];	
		this.output = this.args[6];	
	}	
	
	public String directory() throws Exception {
		if (this.directory == null) {
			this.decompose();
		}
		return this.directory;
	}
	
	public String expression() throws Exception {
		if (this.expression == null) {
			this.decompose();
		}
		return this.expression;
	}
	
	public String mark() throws Exception {
		if (this.mark == null) {
			this.decompose();
		}
		return this.mark;
	}
	
	public String output() throws Exception {
		if (this.output == null) {
			this.decompose();
		}
		return this.output;
	}	
}