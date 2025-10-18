package dz.tarbiya.madrassa.adapter.in.rest.dto;

import java.util.List;

/**
 * Réponse paginée pour les listes d'éléments
 */
public record PagedResponse<T>(
    List<T> content,
    int pageNumber,
    int pageSize,
    long totalElements,
    int totalPages,
    boolean first,
    boolean last,
    boolean hasNext,
    boolean hasPrevious
) {
    
    public static <T> PagedResponse<T> of(List<T> content, int pageNumber, int pageSize, long totalElements) {
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);
        boolean first = pageNumber == 0;
        boolean last = pageNumber >= totalPages - 1;
        boolean hasNext = pageNumber < totalPages - 1;
        boolean hasPrevious = pageNumber > 0;
        
        return new PagedResponse<>(
            content, 
            pageNumber, 
            pageSize, 
            totalElements, 
            totalPages, 
            first, 
            last, 
            hasNext, 
            hasPrevious
        );
    }
}