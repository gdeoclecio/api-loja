package br.com.loja_api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulo não pode ser nulo.")
    @Size(max = 150, message = "Titulo deve conter no maximo 150 caracteres")
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @NotNull(message = "Preço não pode ser nulo")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    @Digits(integer = 8, fraction = 2, message = "preço inválido")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "image", length = 500)
    private String image;

    @NotBlank(message = "Descrição não pode ser nula.")
    @Size(max = 200, message = "Descrição deve conter no maximo 200 caracteres")
    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @NotBlank(message = "Categoria não pode ser vazia.")
    @Size(max = 40, message = "Categoria deve conter no maximo 40 caracteres")
    @Column(name = "category", nullable = false, length = 40)
    private String category;

    public Produto(){}

    public Produto(String title, BigDecimal price, String image, String description, String category){
        this.title = title;
        this.price = price;
        this.image = image;
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
