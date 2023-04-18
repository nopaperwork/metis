package com.metis.nopaper.work.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemoryStats {

	private long heapSize;
    private long heapMaxSize;
    private long heapFreeSize;
    
}
