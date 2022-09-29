package Program;

public class Client {
    private static int clientCounter = 1;
    
    private int clientNumber;
    private String name;
    private String cpf;
    private String email;

    public Client() {}

    //--------------- CONSTRUCTOR ---------------//
    public Client(String name, String cpf, String email) {
        this.clientNumber = clientCounter;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        clientCounter += 1;
    }

    //--------------- NAME INFORMATIONS ---------------//
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //--------------- CPF INFORMATIONS ---------------//
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    //--------------- EMAIL INFORMATIONS ---------------//
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //--------------- CLIENT NUMBER ---------------//
    public int getClientNumber() {
        return clientNumber;
    }
    //--------------- ALL INFORMATIONS ---------------//
    public String toString() {
        return "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nEmail: " + this.getEmail();
    }
}