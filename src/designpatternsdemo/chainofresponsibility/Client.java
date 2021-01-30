package designpatternsdemo.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        Document doc1 = new Document(Authorize.CEO);
        doc1.contents = "some project contents";
        
        Approver director = new DirectorApprover(null, Authorize.DIRECTOR);
        Approver manager = new ManagerApprover(director, Authorize.MANAGER);
        Approver lead = new LeadApprover(manager, Authorize.TEAM_LEAD);
        
        lead.approve(doc1);
        
        System.out.println(doc1.approved);
        System.out.println(doc1.signatures.toString());
    }
}

enum Authorize{
    TEAM_LEAD(1),
    MANAGER(2),
    DIRECTOR(3),
    CEO(4);
    
    int level;
    
    private Authorize(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
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
        if (document.AUTH_LEVEL.getLevel() <= this.authLevel.getLevel()) {
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

class ManagerApprover extends Approver{

    public ManagerApprover(Approver nextApprover, Authorize authLevel) {
        super(nextApprover, authLevel);
    }

    @Override
    protected void addSignature(Document document) {
        System.out.println("Manager signing");
        document.signatures.add("Manager Signature");
    }
}


class DirectorApprover extends Approver{

    public DirectorApprover(Approver nextApprover, Authorize authLevel) {
        super(nextApprover, authLevel);
    }

    @Override
    protected void addSignature(Document document) {
        System.out.println("Director signing");
        document.signatures.add("Director Signature");
    }
}
