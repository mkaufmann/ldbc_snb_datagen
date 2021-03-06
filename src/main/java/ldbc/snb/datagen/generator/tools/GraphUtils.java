package ldbc.snb.datagen.generator.tools;

import ldbc.snb.datagen.objects.Knows;
import ldbc.snb.datagen.objects.Person;

import java.util.*;

/**
 * Created by aprat on 17/06/15.
 */
public class GraphUtils {

    public static double ClusteringCoefficient( PersonGraph graph ) {
        double CC = 0.0;
        for( Long l : graph.persons()) {
            int triangles = 0;
            Set<Long> neighbors = graph.neighbors(l);
            for( Long n : neighbors){
                Set<Long> neighbors2 = graph.neighbors(n);
                Set<Long> aux = new HashSet<Long>(neighbors);
                aux.retainAll(neighbors2);
                triangles+=aux.size();
            }
            int degree = neighbors.size();
            if(triangles > 0)
                CC+=triangles / (double)(degree*(degree-1));
        }
        return CC / graph.persons().size();
    }
}
