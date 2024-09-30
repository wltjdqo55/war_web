package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLegion is a Querydsl query type for Legion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLegion extends EntityPathBase<Legion> {

    private static final long serialVersionUID = -946311579L;

    public static final QLegion legion = new QLegion("legion");

    public final ListPath<General, QGeneral> generals = this.<General, QGeneral>createList("generals", General.class, QGeneral.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath legionName = createString("legionName");

    public final NumberPath<Integer> morale = createNumber("morale", Integer.class);

    public final NumberPath<Integer> movementSpeed = createNumber("movementSpeed", Integer.class);

    public final NumberPath<Integer> totalAttack = createNumber("totalAttack", Integer.class);

    public final NumberPath<Integer> totalDefense = createNumber("totalDefense", Integer.class);

    public final NumberPath<Integer> troopCount = createNumber("troopCount", Integer.class);

    public QLegion(String variable) {
        super(Legion.class, forVariable(variable));
    }

    public QLegion(Path<? extends Legion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLegion(PathMetadata metadata) {
        super(Legion.class, metadata);
    }

}

