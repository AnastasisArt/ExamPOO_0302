public interface ISubject {
    public void ajouterObserver(IObserver observer);
    public void supprimerObserver(IObserver observer);
    public void notifierObserver();
}
