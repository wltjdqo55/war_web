package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSpeciesEntity is a Querydsl query type for SpeciesEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSpeciesEntity extends EntityPathBase<SpeciesEntity> {

    private static final long serialVersionUID = -802815308L;

    public static final QSpeciesEntity speciesEntity = new QSpeciesEntity("speciesEntity");

    public final NumberPath<Integer> attackBonus = createNumber("attackBonus", Integer.class);

    public final NumberPath<Integer> defenseBonus = createNumber("defenseBonus", Integer.class);

    public final NumberPath<Integer> forceBonus = createNumber("forceBonus", Integer.class);

    public final ListPath<General, QGeneral> generals = this.<General, QGeneral>createList("generals", General.class, QGeneral.class, PathInits.DIRECT2);

    public final NumberPath<Integer> intelligenceBonus = createNumber("intelligenceBonus", Integer.class);

    public final ListPath<SoldierEntity, QSoldierEntity> soldier = this.<SoldierEntity, QSoldierEntity>createList("soldier", SoldierEntity.class, QSoldierEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> speciesId = createNumber("speciesId", Long.class);

    public final StringPath speciesName = createString("speciesName");

    public final NumberPath<Integer> spellBonus = createNumber("spellBonus", Integer.class);

    public final NumberPath<Integer> strengthBonus = createNumber("strengthBonus", Integer.class);

    public QSpeciesEntity(String variable) {
        super(SpeciesEntity.class, forVariable(variable));
    }

    public QSpeciesEntity(Path<? extends SpeciesEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpeciesEntity(PathMetadata metadata) {
        super(SpeciesEntity.class, metadata);
    }

}

