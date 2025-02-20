package teste.api.Teste_criacao_api.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_feature")
public class Feature extends BaseItem {
}
