package br.com.orangetalents.mercadolivre.validation.annotation.unique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IsUniqueValidate implements ConstraintValidator<IsUniqueValidator, Object> {

    private String nomeAtributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(IsUniqueValidator validator) {
        nomeAtributo = validator.nomeAtributo();
        this.classe = validator.classe();
    }

    @Override
    public boolean isValid(Object objeto, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + classe.getName() + " WHERE " + nomeAtributo + " = :pNomeAtributo");
        query.setParameter("pNomeAtributo", objeto);

        List<?> lista = query.getResultList();

        if (!lista.isEmpty()) {
            return false;
        }

        return true;
    }
}
