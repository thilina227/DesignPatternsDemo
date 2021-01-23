package designpatternsdemo.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        Document doc1 = new Document(Authorize.TEAM_LEAD);
        doc1.contents = "some project contents";
        
        Approver manager = new ManageApprover(null, Authorize.MANAGER);
        Approver lead = new LeadApprover(manager, Authorize.TEAM_LEAD);
        
        lead.approve(doc1);
        
        System.out.println(doc1.approved);
        System.out.println(doc1.signatures.toString());
    }
}

enum Authorize{
    TEAM_LEAD(1),
    MANAGER(2),
    DIRECTOR(3);
    
    int leve;
    
    private Authorize(int leve) {
        this.leve = leve;
    }

    public int getLeve() {
        return leve;
    }
}

class Document{
    public final Authorize AUTH_LEVEL;
    public String contents;
    public boolean approved;
    public List<String> signatures = new ArrayList<>();

    public Document(Authorize AUTH_LEVEL) {
        this.AUTH_LEVEL = AUTH_LEVEL;
    }
    
}

abstract class Approver{
    
    protected Approver nextApprover;
    private Authorize authLevel;

    public Approver(Approver nextApprover, 
            Authorize authLevel) {
        this.nextApprover = nextApprover;
        this.authLevel = authLevel;
    }
      
    public void approve(Document document){
        if (document.AUTH_LEVEL.getLeve() <= this.authLevel.getLeve()) {
           document.approved = true;
           addSignature(document);
        }
        if (nextApprover != null){
            nextApprover.approve(document);
        }
    }
    
    protected abstract void addSignature(Document document);
}

class LeadApprover extends Approver {

    public LeadApprover(Approver nextApprover, Authorize authLevel) {
        super(nextApprover, authLevel);
    }

    @Override
    protected void addSignature(Document document) {
        System.out.println("Lead signing");
        document.signatures.add("Lead Signature");
    }
}

class ManageApprover extends Approver{

    public ManageApprover(Approver nextApprover, Authorize authLevel) {
        super(nextApprover, authLevel);
    }

    @Override
    protected void addSignature(Document document) {
        System.out.println("Manager signing");
        document.signatures.add("Manager Signature");
    }
}
