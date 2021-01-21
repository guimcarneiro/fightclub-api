package com.guimcarneiro.fightclub.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fight")
public class Fight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "winner_id", referencedColumnName = "id")
	private Wrestler winner;
	
	@ManyToOne
	@JoinColumn(name = "loser_id", referencedColumnName = "id")
	private Wrestler loser;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "name")
	private Category category;

	@Column(name = "happened_at")
	private OffsetDateTime happenedAt;
	
	public Wrestler getWinner() {
		return winner;
	}

	public void setWinner(Wrestler winner) {
		this.winner = winner;
	}

	public Wrestler getLoser() {
		return loser;
	}

	public void setLoser(Wrestler loser) {
		this.loser = loser;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getHappenedAt() {
		return happenedAt;
	}

	public void setHappenedAt(OffsetDateTime happenedAt) {
		this.happenedAt = happenedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fight other = (Fight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
