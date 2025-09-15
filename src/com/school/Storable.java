package com.school;

/**
 * Marker interface for objects that can be saved to storage.
 * Implementing classes must provide a textual representation via
 * toDataString().
 */
public interface Storable {
  /**
   * Convert this object to a comma-separated data string for storage.
   */
  String toDataString();
}
