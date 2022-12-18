import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const survey_url = 'http://localhost:8080/survey';
const answer_survey_url = 'http://localhost:8080/answeredSurvey';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {

  constructor(private http: HttpClient) { }

  public GetQuestions(): Observable<any>{
    return this.http.get(survey_url+`/getQuestions`);
  }

  public AddAnswers(body: any): Observable<any>{
    return this.http.post<any>(survey_url+`/addAnswer`, body);
  }

  public GetAnsweredSurvey(body: any): Observable<any>{
    return this.http.get(answer_survey_url+`/getAllAnsweredSurvey/${body}`);
  }
}
