import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslatePipe } from '../../pipes/translate.pipe';

@Component({
  selector: 'app-classe-list',
  standalone: true,
  imports: [CommonModule, TranslatePipe],
  template: `
    <div class="page-container">
      <h2>{{ 'classes.title' | translate }}</h2>
      <div class="coming-soon">
        <h3>{{ 'classes.comingSoon' | translate }}</h3>
        <p>{{ 'classes.description' | translate }}</p>
        <ul>
          <li>{{ 'classes.features.createModify' | translate }}</li>
          <li>{{ 'classes.features.assignStudents' | translate }}</li>
          <li>{{ 'classes.features.manageTeachers' | translate }}</li>
          <li>{{ 'classes.features.scheduleCourses' | translate }}</li>
        </ul>
      </div>
    </div>
  `,
  styles: [`
    .page-container {
      max-width: 800px;
      margin: 0 auto;
      padding: 2rem;
    }
    .coming-soon {
      background: white;
      padding: 3rem;
      border-radius: 12px;
      text-align: center;
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }
    .coming-soon h3 {
      color: #4CAF50;
      margin-bottom: 1rem;
    }
    .coming-soon ul {
      text-align: left;
      margin-top: 2rem;
    }
    
    /* RTL Support */
    [dir="rtl"] .coming-soon ul {
      text-align: right;
    }
  `]
})
export class ClasseListComponent {}
