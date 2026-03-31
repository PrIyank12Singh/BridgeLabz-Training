import java.util.*;

class Transaction {

    String type;
    int amount;
    int remainingLimit;

    Transaction(String type, int amount, int remainingLimit) {
        this.type = type;
        this.amount = amount;
        this.remainingLimit = remainingLimit;
    }
}

class CreditCard {

    String cardNumber;
    String holderName;
    int creditLimit;
    int availableLimit;
    List<Transaction> transactions = new ArrayList<>();

    CreditCard(String cardNumber, String holderName, int creditLimit) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.creditLimit = creditLimit;
        this.availableLimit = creditLimit;
    }
}

class CreditCardService {

    Map<String, CreditCard> cardMap = new HashMap<>();

    void issueCard(String cardNumber, String holderName, int creditLimit) {

        if (!cardMap.containsKey(cardNumber)) {
            cardMap.put(cardNumber,
                    new CreditCard(cardNumber, holderName, creditLimit));
        }
    }

    void spendAmount(String cardNumber, int amount) {

        CreditCard card = cardMap.get(cardNumber);

        if (card == null || amount > card.availableLimit) {
            System.out.println("Transaction declined");
            return;
        }

        card.availableLimit -= amount;

        card.transactions.add(
                new Transaction("SPEND", amount, card.availableLimit)
        );

        System.out.println("SPENT " + cardNumber + " " + card.availableLimit);
    }

    void makePayment(String cardNumber, int amount) {

        CreditCard card = cardMap.get(cardNumber);

        if (card == null) {
            System.out.println("Card not found");
            return;
        }

        card.availableLimit += amount;

        if (card.availableLimit > card.creditLimit)
            card.availableLimit = card.creditLimit;

        card.transactions.add(
                new Transaction("PAYMENT", amount, card.availableLimit)
        );

        System.out.println("PAYMENT DONE " + cardNumber + " " + card.availableLimit);
    }

    void getCardsByHolder(String holder) {

        List<CreditCard> list = new ArrayList<>();

        for (CreditCard c : cardMap.values()) {
            if (c.holderName.equals(holder))
                list.add(c);
        }

        if (list.isEmpty()) {
            System.out.println("No cards found");
            return;
        }

        list.sort(Comparator.comparing(c -> c.cardNumber));

        for (CreditCard c : list) {
            System.out.println(c.cardNumber + " " + c.availableLimit);
        }
    }
}

public class CreditCardAccountManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        CreditCardService service = new CreditCardService();

        while (n-- > 0) {

            String line = sc.nextLine();
            String[] p = line.split(" ");

            switch (p[0]) {

                case "ISSUE":
                    service.issueCard(
                            p[1],
                            p[2],
                            Integer.parseInt(p[3])
                    );
                    break;

                case "SPEND":
                    service.spendAmount(
                            p[1],
                            Integer.parseInt(p[2])
                    );
                    break;

                case "PAYMENT":
                    service.makePayment(
                            p[1],
                            Integer.parseInt(p[2])
                    );
                    break;

                case "HOLDER":
                    service.getCardsByHolder(p[1]);
                    break;
            }
        }
    }
}