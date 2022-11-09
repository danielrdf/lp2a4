
public class MinhaThread implements Runnable {

	private String nome;
	private int tempo;

	public MinhaThread(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(nome + " passo " + i);
				Thread.sleep(tempo);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nome + " terminou a execução");
	}

}
