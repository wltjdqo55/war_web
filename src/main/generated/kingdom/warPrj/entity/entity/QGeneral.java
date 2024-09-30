package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeneral is a Querydsl query type for General
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGeneral extends EntityPathBase<General> {

    private static final long serialVersionUID = 592909085L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeneral general = new QGeneral("general");

    public final NumberPath<Integer> attackBonus = createNumber("attackBonus", Integer.class);

    public final NumberPath<Integer> defenseBonus = createNumber("defenseBonus", Integer.class);

    public final NumberPath<Integer> generalAge = createNumber("generalAge", Integer.class);

    public final StringPath generalName = createString("generalName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Legion, QLegion> legions = this.<Legion, QLegion>createList("legions", Legion.class, QLegion.class, PathInits.DIRECT2);

    public final NumberPath<Integer> moraleBonus = createNumber("moraleBonus", Integer.class);

    public final NumberPath<Integer> movementSpeed = createNumber("movementSpeed", Integer.class);

    public final QSpeciesEntity species;

    public QGeneral(String variable) {
        this(General.class, forVariable(variable), INITS);
    }

    public QGeneral(Path<? extends General> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeneral(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeneral(PathMetadata metadata, PathInits inits) {
        this(General.class, metadata, inits);
    }

    public QGeneral(Class<? extends General> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.species = inits.isInitialized("species") ? new QSpeciesEntity(forProperty("species")) : null;
    }

}

