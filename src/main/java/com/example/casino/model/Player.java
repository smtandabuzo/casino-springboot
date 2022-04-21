package com.example.casino.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;
import javax.persistence.Table;



@Entity
@Table(name = "CASINO")

@NamedNativeQuery(
    name = "find_unique_players",
    query =
            "SELECT "
                    + "c.transaction_type as transactionType, c.transactionId as transactionId, c.balance as balance "
                    + "from CASINO c group by c.username",
    resultSetMapping = "unique_players"
)
@SqlResultSetMapping(
    name = "unique_players",
    classes = @ConstructorResult(
            targetClass = Player.class,
            columns = {
                    @ColumnResult(name = "transactionType", type = String.class),
                    @ColumnResult(name = "amount", type = Float.class)
            }
    )
)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLAYER_ID", nullable = false)
    private Integer playerId;
	@Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "BALANCE", nullable = false)
    private Double balance;
	@Column(name = "TRANSACTION_TYPE", nullable = true)
    private String transactionType;


    public Player() {

	}

	public Player(Integer playerId, String username, Double balance) {
		this.playerId = playerId;
		this.balance = balance;
		this.username = username;
	}

    public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

    @Override
	public String toString() {
		return "Casino [playerId=" + playerId + ", balance=" + balance + ", username=" + username + ", transaction type=" + transactionType + "]";
	}
}
